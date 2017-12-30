package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Showroom {
  private VDMSet startups = SetUtil.set();
  private Types.Date DayOfStart;
  private Types.Date DayOfEnd;

  public void cg_init_Showroom_1(final Types.Date n2, final Types.Date n3) {

    DayOfStart = Utils.copy(n2);
    DayOfEnd = Utils.copy(n3);
    return;
  }

  public Showroom(final Types.Date n2, final Types.Date n3) {

    cg_init_Showroom_1(Utils.copy(n2), Utils.copy(n3));
  }

  public void addStartupToShowroom(final startup n1) {

    startups = SetUtil.union(Utils.copy(startups), SetUtil.set(n1));
  }

  public VDMSet getStartups() {

    return Utils.copy(startups);
  }

  public Types.Date getDayOfStart() {

    return Utils.copy(DayOfStart);
  }

  public startup getStartupByName(final String n1) {

    startup temp = null;
    for (Iterator iterator_2 = startups.iterator(); iterator_2.hasNext(); ) {
      startup companies = (startup) iterator_2.next();
      if (Utils.equals(companies.getName(), n1)) {
        temp = companies;
      }
    }
    return temp;
  }

  public VDMSet getStartupByCountry(final String n1) {

    VDMSet temp = SetUtil.set();
    for (Iterator iterator_3 = startups.iterator(); iterator_3.hasNext(); ) {
      startup companies = (startup) iterator_3.next();
      if (Utils.equals(companies.getCountryOfOrigin(), n1)) {
        temp = SetUtil.union(Utils.copy(temp), SetUtil.set(companies));
      }
    }
    return Utils.copy(temp);
  }

  public Showroom() {}

  public String toString() {

    return "Showroom{"
        + "startups := "
        + Utils.toString(startups)
        + ", DayOfStart := "
        + Utils.toString(DayOfStart)
        + ", DayOfEnd := "
        + Utils.toString(DayOfEnd)
        + "}";
  }
}
