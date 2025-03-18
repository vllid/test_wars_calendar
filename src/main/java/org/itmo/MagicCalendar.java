package org.itmo;

import java.util.ArrayList;
import java.util.List;

public class MagicCalendar {
    // Перечисление типов встреч
    public enum MeetingType {
        WORK, PERSONAL
    }

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
        return true;
    }

    /**
     * Получить список всех встреч пользователя.
     *
     * @param user имя пользователя
     * @return список временных слотов, на которые запланированы встречи.
     */
    public List<String> getMeetings(String user) {
        // Реализация метода
        return new ArrayList<>();
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
        return false;
    }
}
