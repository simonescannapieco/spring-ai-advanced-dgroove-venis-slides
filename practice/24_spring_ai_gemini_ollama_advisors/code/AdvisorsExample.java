chatClient
    .prompt()
    .advisors(List.of(new SimpleLoggerAdvisor(1), new SafeGuardAdvisor(0)))
    .user(message)
    .call()
    .content();
