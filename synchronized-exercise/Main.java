public class Main {
    public static void main(String[] args){
        Data data = new Data();
        Producer producer = new Producer(data);
        Consumer consumer = new Consumer(data);

        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                System.out.println("Shutdown hook ran! Here is the data:");
                producer.printHistory();
                consumer.printHistory();
            }
        });


        Thread threadProducer = new Thread(producer);
        Thread threadConsumer = new Thread(consumer);

        System.out.println("Starting producer thread!");
        threadProducer.start();
        System.out.println("Starting consumer thread!");
        threadConsumer.start();

        while (true){ } // produce and consume data until SIGINT.
    }
}