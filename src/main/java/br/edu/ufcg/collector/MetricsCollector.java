package br.edu.ufcg.collector;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Collector.MetricFamilySamples;

public class MetricsCollector {
    @Autowired
    private CollectorRegistry collectorRegistry;

    public List<Object> hello() {
        Enumeration<MetricFamilySamples> samples = this.collectorRegistry.metricFamilySamples();
        List<Object> samplesList = new ArrayList<>();
        while (samples.hasMoreElements()) {
            samplesList.add(samples.nextElement().samples);
        }

        for (Object object : samplesList) {
            System.out.println(String.valueOf(object));
        }

        return samplesList;
    }
}
