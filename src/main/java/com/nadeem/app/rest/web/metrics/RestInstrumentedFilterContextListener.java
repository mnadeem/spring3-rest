package com.nadeem.app.rest.web.metrics;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.servlet.InstrumentedFilterContextListener;
import com.nadeem.app.rest.common.RestSharedMetricRegistry;

public class RestInstrumentedFilterContextListener extends InstrumentedFilterContextListener
{

    @Override
    protected MetricRegistry getMetricRegistry()
    {
        return RestSharedMetricRegistry.getDefault();
    }
}
