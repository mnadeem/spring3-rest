package com.nadeem.app.rest.common;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.SharedMetricRegistries;

public class RestSharedMetricRegistry
{

    public static final String DEFAULT_REGISTRY_NAME = "DEFAULT_METRIC_REGISTRY";

    private RestSharedMetricRegistry() { /* singleton */ }

    public static MetricRegistry getDefault() {
        return SharedMetricRegistries.getOrCreate(DEFAULT_REGISTRY_NAME);
    }

}
