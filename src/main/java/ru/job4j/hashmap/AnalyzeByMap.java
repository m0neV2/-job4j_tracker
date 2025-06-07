package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int totalscore = 0;
        int countsubject = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalscore += subject.score();
                countsubject++;
            }
        }
        return (double) totalscore / countsubject;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int totalscore = 0;
            int countsubject = 0;

            for (Subject subject : pupil.subjects()) {
                totalscore += subject.score();
                countsubject++;
            }
            double average = (double) totalscore / countsubject;
            result.add(new Label(pupil.name(), average));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new HashMap<>();
        Map<String, Integer> subjectCounts = new HashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String name = subject.name();
                int score = subject.score();
                subjectScores.put(name, subjectScores.getOrDefault(name, 0) + score);
                subjectCounts.put(name, subjectCounts.getOrDefault(name, 0) + 1);
            }
        }

        List<Label> result = new ArrayList<>();
        for (String subjectName : subjectScores.keySet()) {
            int totalScore = subjectScores.get(subjectName);
            int count = subjectCounts.get(subjectName);
            double average = (double) totalScore / count;
            result.add(new Label(subjectName, average));
        }

        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int totalscore = 0;
            for (Subject subject : pupil.subjects()) {
                totalscore += subject.score();
            }
            result.add(new Label(pupil.name(), totalscore));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
            Map<String, Integer> subjectScores = new HashMap<>();
            for (Pupil pupil : pupils) {
                for (Subject subject : pupil.subjects()) {
                    String name = subject.name();
                    subjectScores.put(name, subjectScores.getOrDefault(name, 0) + subject.score());
                }
            }

            Label best = null;
            for (Map.Entry<String, Integer> entry : subjectScores.entrySet()) {
                Label current = new Label(entry.getKey(), entry.getValue());
                if (best == null || current.compareTo(best) > 0) {
                    best = current;
                }
            }
            return best;
        }
}
