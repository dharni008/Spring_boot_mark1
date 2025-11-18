package first_project.Spring_boot_mark1.ErrorHandlers;

import java.io.IOException;

public class InputOutputEx extends IOException {
    public InputOutputEx(String message) {
        super(message);
    }
}
