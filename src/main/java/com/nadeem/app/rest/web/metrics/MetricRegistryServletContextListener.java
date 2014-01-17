package com.nadeem.app.rest.web.metrics;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.servlets.MetricsServlet;
import com.nadeem.app.rest.common.RestSharedMetricRegistry;

public class MetricRegistryServletContextListener extends MetricsServlet.ContextListener
{
    @Override
    protected MetricRegistry getMetricRegistry()
    {
        return RestSharedMetricRegistry.getDefault();
    }

}
