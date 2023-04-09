package com.restful.runners;

import com.restful.report.ReporteCucumber;
import com.intuit.karate.KarateOptions;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.Test;

import static com.restful.utils.Parametros.AMBIENTE;
import static com.restful.utils.Parametros.RUTA_REPORTES;
import static org.junit.Assert.assertEquals;

@KarateOptions(features = {"src/test/resources/features/Login.feature"})
public class BaseRunner {
    @Test
    public void runTest() {
        System.setProperty("karate.env", AMBIENTE);
        Results results = Runner.parallel(getClass(), 1, RUTA_REPORTES);
        ReporteCucumber.generar();
        assertEquals(results.getErrorMessages(), 0, results.getFailCount());
    }
}
