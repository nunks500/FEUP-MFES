package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Types {
  public Types() {}

  public String toString() {

    return "Types{}";
  }

  public static class Time implements Record {
    public Number hours;
    public Number minutes;
    public Number seconds;

    public Time(final Number _hours, final Number _minutes, final Number _seconds) {

      hours = _hours;
      minutes = _minutes;
      seconds = _seconds;
    }

    public boolean equals(final Object obj) {

      if (!(obj instanceof Time)) {
        return false;
      }

      Time other = ((Time) obj);

      return (Utils.equals(hours, other.hours))
          && (Utils.equals(minutes, other.minutes))
          && (Utils.equals(seconds, other.seconds));
    }

    public int hashCode() {

      return Utils.hashCode(hours, minutes, seconds);
    }

    public Time copy() {

      return new Time(hours, minutes, seconds);
    }

    public String toString() {

      return "mk_Types`Time" + Utils.formatFields(hours, minutes, seconds);
    }
  }

  public static Boolean inv_Time(final Time tempo) {

    Boolean andResult_11 = false;

    if (tempo.minutes.longValue() >= 0L) {
      Boolean andResult_12 = false;

      if (tempo.minutes.longValue() < 60L) {
        Boolean andResult_13 = false;

        if (tempo.seconds.longValue() >= 0L) {
          Boolean andResult_14 = false;

          if (tempo.seconds.longValue() < 60L) {
            if (tempo.hours.longValue() >= 0L) {
              andResult_14 = true;
            }
          }

          if (andResult_14) {
            andResult_13 = true;
          }
        }

        if (andResult_13) {
          andResult_12 = true;
        }
      }

      if (andResult_12) {
        andResult_11 = true;
      }
    }

    return andResult_11;
  }

  public static class Date implements Record {
    public Number day;
    public Number month;
    public Number year;

    public Date(final Number _day, final Number _month, final Number _year) {

      day = _day;
      month = _month;
      year = _year;
    }

    public boolean equals(final Object obj) {

      if (!(obj instanceof Date)) {
        return false;
      }

      Date other = ((Date) obj);

      return (Utils.equals(day, other.day))
          && (Utils.equals(month, other.month))
          && (Utils.equals(year, other.year));
    }

    public int hashCode() {

      return Utils.hashCode(day, month, year);
    }

    public Date copy() {

      return new Date(day, month, year);
    }

    public String toString() {

      return "mk_Types`Date" + Utils.formatFields(day, month, year);
    }
  }

  public static Boolean inv_Date(final Date datas) {

    Boolean andResult_19 = false;

    if (datas.year.longValue() >= 0L) {
      Boolean andResult_20 = false;

      if (datas.month.longValue() > 0L) {
        Boolean andResult_21 = false;

        if (datas.month.longValue() <= 12L) {
          Boolean andResult_22 = false;

          if (datas.day.longValue() > 0L) {
            if (datas.day.longValue() <= 31L) {
              andResult_22 = true;
            }
          }

          if (andResult_22) {
            andResult_21 = true;
          }
        }

        if (andResult_21) {
          andResult_20 = true;
        }
      }

      if (andResult_20) {
        andResult_19 = true;
      }
    }

    return andResult_19;
  }
}
