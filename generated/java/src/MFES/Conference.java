package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Conference {
  private VDMSet speakers = SetUtil.set();
  private VDMSet attendees = SetUtil.set();
  private String title;

  public void cg_init_Conference_2(final String n1, final VDMSet n2) {

    title = n1;
    speakers = Utils.copy(n2);
    return;
  }

  public void cg_init_Conference_1(final String n1, final VDMSet n2, final VDMSet n3) {

    title = n1;
    speakers = Utils.copy(n2);
    attendees = Utils.copy(n3);
    return;
  }

  public Conference(final String n1, final VDMSet n2, final VDMSet n3) {

    cg_init_Conference_1(n1, Utils.copy(n2), Utils.copy(n3));
  }

  public Conference(final String n1, final VDMSet n2) {

    cg_init_Conference_2(n1, Utils.copy(n2));
  }

  public VDMSet getLAttendees() {

    return Utils.copy(attendees);
  }

  public VDMSet getSpeakers() {

    return Utils.copy(speakers);
  }

  public Number getAttendees() {

    Number count = 0L;
    for (Iterator iterator_1 = attendees.iterator(); iterator_1.hasNext(); ) {
      Attendee attendee = (Attendee) iterator_1.next();
      count = count.doubleValue() + 1L;
    }
    return count;
  }

  public String getTitle() {

    return title;
  }

  public void addAttendee(final Attendee attendee) {

    attendees = SetUtil.union(Utils.copy(attendees), SetUtil.set(attendee));
  }

  public Conference() {}

  public String toString() {

    return "Conference{"
        + "speakers := "
        + Utils.toString(speakers)
        + ", attendees := "
        + Utils.toString(attendees)
        + ", title := "
        + Utils.toString(title)
        + "}";
  }
}
