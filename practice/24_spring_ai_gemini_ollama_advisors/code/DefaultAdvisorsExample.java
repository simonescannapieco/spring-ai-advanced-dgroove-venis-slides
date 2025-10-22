chatClientBuilder
    .defaultAdvisors(List.of(new SimpleLoggerAdvisor(1), new SafeGuardAdvisor(0)))
    .build();