interface Logger {
    void log(String message);
}

class FileLogger implements Logger {
    public void log(String message) {
        System.out.println("log:"+message);
    }
}

class OrderProcessor {
    private Logger logger;

    public OrderProcessor(Logger logger) {
        this.logger = logger;
    }

    public void processOrder() {
        logger.log("order processed");
    }
}
