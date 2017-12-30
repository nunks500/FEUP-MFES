package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Schedule {
  private Types.Time TimeOfStart;
  private Types.Date DayOfStart;
  private Stage stage;
  private Conference conference;

  public void cg_init_Schedule_1(
      final Types.Time n1, final Types.Date n2, final Stage n3, final Conference n4) {

    TimeOfStart = Utils.copy(n1);
    DayOfStart = Utils.copy(n2);
    stage = n3;
    conference = n4;
    return;
  }

  public Schedule(final Types.Time n1, final Types.Date n2, final Stage n3, final Conference n4) {

    cg_init_Schedule_1(Utils.copy(n1), Utils.copy(n2), n3, n4);
  }

  public Types.Date getDayOfStart() {

    return Utils.copy(DayOfStart);
  }

  public Types.Time getTimeOfStart() {

    return Utils.copy(TimeOfStart);
  }

  public Conference getConference() {

    return conference;
  }

  public Stage getStage() {

    return stage;
  }

  public Schedule() {}

  public String toString() {

    return "Schedule{"
        + "TimeOfStart := "
        + Utils.toString(TimeOfStart)
        + ", DayOfStart := "
        + Utils.toString(DayOfStart)
        + ", stage := "
        + Utils.toString(stage)
        + ", conference := "
        + Utils.toString(conference)
        + "}";
  }
}
