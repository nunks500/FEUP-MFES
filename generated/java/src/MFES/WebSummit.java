package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class WebSummit {
  private VDMSet jornal = SetUtil.set();
  private VDMSet startups = SetUtil.set();
  private VDMSet Schedules = SetUtil.set();
  private VDMSet Showrooms = SetUtil.set();
  public static WebSummit websumit = new WebSummit();

  public void addNews(final News news) {

    jornal = SetUtil.union(Utils.copy(jornal), SetUtil.set(news));
  }

  public void addShowroom(final Showroom show) {

    Showrooms = SetUtil.union(Utils.copy(Showrooms), SetUtil.set(show));
  }

  public VDMSet getNews() {

    return Utils.copy(jornal);
  }

  public VDMSet getStartups() {

    return Utils.copy(startups);
  }

  public VDMSet getSchedules() {

    return Utils.copy(Schedules);
  }

  public void addStartup(final startup startup) {

    startups = SetUtil.union(Utils.copy(startups), SetUtil.set(startup));
  }

  public News getNewsByTitle(final String n1) {

    News temp = null;
    for (Iterator iterator_4 = jornal.iterator(); iterator_4.hasNext(); ) {
      News noticias = (News) iterator_4.next();
      if (Utils.equals(noticias.getTitle(), n1)) {
        temp = noticias;
      }
    }
    return temp;
  }

  public VDMSet getTalksByName(final String n1) {

    VDMSet temp = SetUtil.set();
    for (Iterator iterator_5 = Schedules.iterator(); iterator_5.hasNext(); ) {
      Schedule eventos = (Schedule) iterator_5.next();
      for (Iterator iterator_6 = eventos.getConference().getSpeakers().iterator();
          iterator_6.hasNext();
          ) {
        Speaker speaker = (Speaker) iterator_6.next();
        if (Utils.equals(n1, speaker.getName())) {
          temp = SetUtil.union(Utils.copy(temp), SetUtil.set(eventos));
        }
      }
    }
    return Utils.copy(temp);
  }

  public void addSchedule(final Schedule schedule) {

    Number exist = 0L;
    for (Iterator iterator_7 = Schedules.iterator(); iterator_7.hasNext(); ) {
      Schedule schedulez = (Schedule) iterator_7.next();
      Boolean andResult_27 = false;

      if (Utils.equals(schedulez.getStage(), schedule.getStage())) {
        Boolean andResult_28 = false;

        if (Utils.equals(schedulez.getDayOfStart(), schedule.getDayOfStart())) {
          if (Utils.equals(schedulez.getTimeOfStart(), schedule.getTimeOfStart())) {
            andResult_28 = true;
          }
        }

        if (andResult_28) {
          andResult_27 = true;
        }
      }

      if (andResult_27) {
        IO.println("Cannot have two events at the same stage on the same time");
        exist = 1L;
      }
    }
    for (Iterator iterator_8 = Schedules.iterator(); iterator_8.hasNext(); ) {
      Schedule schedulez = (Schedule) iterator_8.next();
      for (Iterator iterator_9 = schedulez.getConference().getLAttendees().iterator();
          iterator_9.hasNext();
          ) {
        Attendee name = (Attendee) iterator_9.next();
        for (Iterator iterator_10 = schedule.getConference().getLAttendees().iterator();
            iterator_10.hasNext();
            ) {
          Attendee name2 = (Attendee) iterator_10.next();
          Boolean andResult_29 = false;

          if (Utils.equals(schedule.getDayOfStart(), schedulez.getDayOfStart())) {
            Boolean andResult_30 = false;

            if (Utils.equals(schedule.getTimeOfStart(), schedulez.getTimeOfStart())) {
              Boolean andResult_31 = false;

              if (!(Utils.equals(
                  schedule.getConference().getTitle(), schedulez.getConference().getTitle()))) {
                if (Utils.equals(name2, name)) {
                  andResult_31 = true;
                }
              }

              if (andResult_31) {
                andResult_30 = true;
              }
            }

            if (andResult_30) {
              andResult_29 = true;
            }
          }

          if (andResult_29) {
            IO.println("One Cannot Attend 2 events in the same time");
            exist = 1L;
          }
        }
      }
    }
    for (Iterator iterator_11 = Schedules.iterator(); iterator_11.hasNext(); ) {
      Schedule schedulez = (Schedule) iterator_11.next();
      for (Iterator iterator_12 = schedulez.getConference().getSpeakers().iterator();
          iterator_12.hasNext();
          ) {
        Speaker name = (Speaker) iterator_12.next();
        for (Iterator iterator_13 = schedule.getConference().getSpeakers().iterator();
            iterator_13.hasNext();
            ) {
          Speaker name2 = (Speaker) iterator_13.next();
          Boolean andResult_32 = false;

          if (Utils.equals(schedule.getDayOfStart(), schedulez.getDayOfStart())) {
            Boolean andResult_33 = false;

            if (Utils.equals(schedule.getTimeOfStart(), schedulez.getTimeOfStart())) {
              Boolean andResult_34 = false;

              if (!(Utils.equals(
                  schedule.getConference().getTitle(), schedulez.getConference().getTitle()))) {
                if (Utils.equals(name2, name)) {
                  andResult_34 = true;
                }
              }

              if (andResult_34) {
                andResult_33 = true;
              }
            }

            if (andResult_33) {
              andResult_32 = true;
            }
          }

          if (andResult_32) {
            IO.println("One Cannot Attend 2 events in the same time");
            exist = 1L;
          }
        }
      }
    }
    if (Utils.equals(exist, 0L)) {
      Schedules = SetUtil.union(Utils.copy(Schedules), SetUtil.set(schedule));
    }
  }

  public VDMSet getConferenceAt(final Types.Date n1, final Types.Time n2) {

    VDMSet events = SetUtil.set();
    for (Iterator iterator_14 = Schedules.iterator(); iterator_14.hasNext(); ) {
      Schedule schedule = (Schedule) iterator_14.next();
      Boolean andResult_35 = false;

      if (Utils.equals(schedule.getDayOfStart(), n1)) {
        if (Utils.equals(schedule.getTimeOfStart(), n2)) {
          andResult_35 = true;
        }
      }

      if (andResult_35) {
        events = SetUtil.union(Utils.copy(events), SetUtil.set(schedule));
      }
    }
    return Utils.copy(events);
  }

  public Schedule getConferenceWithTitle(final String n1) {

    Schedule event = null;
    for (Iterator iterator_15 = Schedules.iterator(); iterator_15.hasNext(); ) {
      Schedule schedule = (Schedule) iterator_15.next();
      if (Utils.equals(schedule.getConference().getTitle(), n1)) {
        event = schedule;
      }
    }
    return event;
  }

  public Showroom getShowroomByDate(final Types.Date n1) {

    Showroom show2 = null;
    for (Iterator iterator_16 = Showrooms.iterator(); iterator_16.hasNext(); ) {
      Showroom show = (Showroom) iterator_16.next();
      if (Utils.equals(show.getDayOfStart(), n1)) {
        show2 = show;
      }
    }
    return show2;
  }

  public void addAttendeetoConference(final Attendee n1, final Schedule n2) {

    Number exist = 0L;
    for (Iterator iterator_17 = Schedules.iterator(); iterator_17.hasNext(); ) {
      Schedule schedulez = (Schedule) iterator_17.next();
      Boolean andResult_36 = false;

      if (!(Utils.equals(schedulez.getStage(), n2.getStage()))) {
        Boolean andResult_37 = false;

        if (Utils.equals(schedulez.getDayOfStart(), n2.getDayOfStart())) {
          Boolean andResult_38 = false;

          if (Utils.equals(schedulez.getTimeOfStart(), n2.getTimeOfStart())) {
            if (SetUtil.inSet(n1, schedulez.getConference().getLAttendees())) {
              andResult_38 = true;
            }
          }

          if (andResult_38) {
            andResult_37 = true;
          }
        }

        if (andResult_37) {
          andResult_36 = true;
        }
      }

      if (andResult_36) {
        IO.print("Cannot add Attendee that already is signed up on another event");
        exist = 1L;
      }
    }
    if (Utils.equals(exist, 0L)) {
      n2.getConference().addAttendee(n1);
    }
  }

  public WebSummit() {}

  public String toString() {

    return "WebSummit{"
        + "jornal := "
        + Utils.toString(jornal)
        + ", startups := "
        + Utils.toString(startups)
        + ", Schedules := "
        + Utils.toString(Schedules)
        + ", Showrooms := "
        + Utils.toString(Showrooms)
        + ", websumit := "
        + Utils.toString(websumit)
        + "}";
  }
}
