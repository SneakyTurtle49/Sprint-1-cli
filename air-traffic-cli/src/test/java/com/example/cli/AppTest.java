
package com.example.cli;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testMainMethod() {
        assertDoesNotThrow(() -> {
            String[] args = {};
            App.main(args);
        });
    }
}
