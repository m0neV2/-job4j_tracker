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
        List<Label> result = new ArrayList<>();
        List<String> subjectNames = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (!subjectNames.contains(subject.name())) {
                    subjectNames.add(subject.name());
                }
            }
        }

        for (String subjectName : subjectNames) {
            int score = 0;
            int countpupil = 0;
            for (Pupil pupil : pupils) {
                for (Subject subject : pupil.subjects()) {
                    if (subject.name().equals(subjectName)) {
                        score += subject.score();
                        countpupil++;
                    }
                }
            }
            double average = (double) score / countpupil;
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
            List<Label> result = new ArrayList<>();
            List<String> subjectNames = new ArrayList<>();
            for (Pupil pupil : pupils) {
                for (Subject subject : pupil.subjects()) {
                    if (!subjectNames.contains(subject.name())) {
                        subjectNames.add(subject.name());
                    }
                }
            }

            for (String subjectName : subjectNames) {
                int score = 0;
                for (Pupil pupil : pupils) {
                    for (Subject subject : pupil.subjects()) {
                        if (subject.name().equals(subjectName)) {
                            score += subject.score();
                        }
                    }
                }
                result.add(new Label(subjectName, score));
            }
            result.sort(Comparator.naturalOrder());
            return result.get(result.size() - 1);
        }
    }