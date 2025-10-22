chatClient
    .prompt()
    .advisors(new SimpleLoggerAdvisor(1), new SafeGuardAdvisor(0))
    .user(message)
    .call()
    .content();
