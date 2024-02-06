package SpringNoticeBoard.NoticeBoard.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeValue {

    public static String setDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateToString = dateFormat.format(date);
        return dateToString;
    }
}
