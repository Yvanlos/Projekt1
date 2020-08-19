package model;

public enum Stage {
    NEW,
    ANALYSE_IN_PROGRESS,
    ANALYSE_FINISHED,
    IMPLEMENTATION_IN_PROGRESS,
    IMPLEMENTATION_FINISHED,
    TEST_IN_PROGRESS,
    TEST_FINISHED,COMPLETED;

    private final static Stage[] stages = values();

    public Stage next(){
        if (this.ordinal() < stages.length){
            return stages[this.ordinal()+1];
        }
        return this;
    }

    public Stage previous(){
        if (this.ordinal() > 0){
            return stages[this.ordinal()-1];
        }
        return this;
    }
}
