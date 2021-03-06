package delight.rhinosandox.tests;

import delight.rhinosandox.RhinoSandbox;
import delight.rhinosandox.RhinoSandboxes;
import delight.rhinosandox.exceptions.ScriptCPUAbuseException;
import org.junit.Test;

@SuppressWarnings("all")
public class TestCPUViolation {
  @Test(expected = ScriptCPUAbuseException.class)
  public void test() {
    final RhinoSandbox sandbox = RhinoSandboxes.create();
    sandbox.setInstructionLimit(50000);
    Class<? extends TestCPUViolation> _class = this.getClass();
    String _plus = ("Test_" + _class);
    sandbox.eval(_plus, "while (true) { };");
  }
  
  @Test
  public void test_all_okay() {
    final RhinoSandbox sandbox = RhinoSandboxes.create();
    sandbox.setInstructionLimit(200000);
    Class<? extends TestCPUViolation> _class = this.getClass();
    String _plus = ("Test_" + _class);
    sandbox.eval(_plus, "for (var i=0;i<=10000;i++) { };");
  }
}
