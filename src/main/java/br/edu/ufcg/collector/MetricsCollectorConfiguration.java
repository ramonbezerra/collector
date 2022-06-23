package br.edu.ufcg.collector;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Collector.MetricFamilySamples;

@Configuration
@ComponentScan
public class MetricsCollectorConfiguration {
    @Autowired
    private CollectorRegistry collectorRegistry;

    @Bean
    public List<Object> metricSamples() {
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
