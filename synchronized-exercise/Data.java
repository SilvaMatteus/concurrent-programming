class Data {
    private int value = -1;

    synchronized int pop(){
        int tmp = this.value;
        this.value = -1;
        return tmp;
    }

    synchronized void put(int value){
        this.value = value;
    }

    synchronized int peek(){
        return this.value;
    }
}
