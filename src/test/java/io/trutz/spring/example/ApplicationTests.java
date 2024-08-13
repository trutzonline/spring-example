package io.trutz.spring.example;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class ApplicationTests {

    @Test
    void hasNoViolations() {
        var modules = ApplicationModules.of(SpringExampleApplication.class).verify();
        new Documenter(modules)
                .writeModulesAsPlantUml()
                .writeIndividualModulesAsPlantUml();
    }

}
