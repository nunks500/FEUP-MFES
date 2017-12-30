package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Attendee {
  public String name;

  public void cg_init_Attendee_1(final String n1) {

    name = n1;
    return;
  }

  public Attendee(final String n1) {

    cg_init_Attendee_1(n1);
  }

  public Attendee() {}

  public String toString() {

    return "Attendee{" + "name := " + Utils.toString(name) + "}";
  }
}
