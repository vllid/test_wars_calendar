package org.itmo;

import java.util.*;

public class MagicCalendar {
    // Перечисление типов встреч
    public enum MeetingType {
        WORK, PERSONAL
    }

    private final Map<Map.Entry<Integer, String>, MeetingType> meetings = new HashMap<>();

    /**
     * Запланировать встречу для пользователя.
     *
     * @param user имя пользователя
     * @param time временной слот (например, "10:00")
     * @param type тип встречи (WORK или PERSONAL)
     * @return true, если встреча успешно запланирована, false если:
     *         - в этот временной слот уже есть встреча, и правило замены не выполняется,
     *         - лимит в 5 встреч в день уже достигнут.
     */
    public boolean scheduleMeeting(String user, String time, MeetingType type) {
        // Реализация метода

        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3, 5));


        if (hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59) {
            int sumMinutes = hours * 60 + minutes;

            var userMeetings = meetings.keySet().stream().filter(k -> k.getValue().equals(user)).count();

            if (userMeetings < 5) {
                if (meetings.keySet().stream().anyMatch(m ->
                        m.getKey() >= sumMinutes && m.getKey() < (sumMinutes + 60) && m.getValue().equals(user))) {

                    var timeInRange = meetings.keySet().stream().filter(
                            m -> m.getKey() >= sumMinutes && m.getKey() < (sumMinutes + 60) && m.getValue().equals(user)
                    ).findFirst().get();

                    var meeting = meetings.get(timeInRange);

                    if (type == MeetingType.PERSONAL && meeting.equals(MeetingType.WORK)) {
                        meetings.remove(timeInRange);
                        meetings.put(Map.entry(sumMinutes, user), type);
                    } else {
                        return false;
                    }
                } else {
                    meetings.put(Map.entry(sumMinutes, user), type);
                }

                return true;
            }
        }

        return false;
    }

    /**
     * Получить список всех встреч пользователя.
     *
     * @param user имя пользователя
     * @return список временных слотов, на которые запланированы встречи.
     */
    public List<String> getMeetings(String user) {
        // Реализация метода
        return meetings.keySet().stream().filter(k -> k.getValue().equals(user)).map(Map.Entry::getValue).toList();
    }

    /**
     * Отменить встречу для пользователя по заданному времени.
     *
     * @param user имя пользователя
     * @param time временной слот, который нужно отменить.
     * @return true, если встреча была успешно отменена; false, если:
     *         - встреча в указанное время отсутствует,
     *         - встреча имеет тип PERSONAL (отменять можно только WORK встречу).
     */
    public boolean cancelMeeting(String user, String time) {
        // Реализация метода

        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3, 5));

        if (hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59) {
            int sumMinutes = hours * 60 + minutes;

            if (meetings.keySet().stream().anyMatch(m ->
                    m.getKey() >= sumMinutes && m.getKey() < (sumMinutes + 60) && m.getValue().equals(user))) {

                var timeInRange = meetings.keySet().stream().filter(
                        m -> m.getKey() >= sumMinutes && m.getKey() < (sumMinutes + 60) && m.getValue().equals(user)
                ).findFirst().get();

                var meeting = meetings.get(timeInRange);

                if (meeting.equals(MeetingType.WORK)) {
                    meetings.remove(timeInRange);
                    return true;
                }
            }

        }

        return false;
    }
}
