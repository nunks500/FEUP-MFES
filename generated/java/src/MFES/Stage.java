package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Stage {
  private String name;
  private Number capacity;

  public void cg_init_Stage_1(final String n1, final Number n2) {

    name = n1;
    capacity = n2;
    return;
  }

  public Stage(final String n1, final Number n2) {

    cg_init_Stage_1(n1, n2);
  }

  public Number getCapacity() {

    return capacity;
  }

  public Stage() {}

  public String toString() {

    return "Stage{"
        + "name := "
        + Utils.toString(name)
        + ", capacity := "
        + Utils.toString(capacity)
        + "}";
  }
}
