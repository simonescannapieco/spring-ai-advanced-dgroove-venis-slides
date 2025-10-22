chatClientBuilder
    .defaultAdvisors(new SimpleLoggerAdvisor(1), new SafeGuardAdvisor(0))
    .build();