package nuberbiggame;

public abstract class JudgeNumber {

    public void judgeNumber(int entryNumber) {

        int randomNumber = (int) (Math.random() * 10);
        System.out.println("randomNumber: " + randomNumber);

        if(entryNumber > randomNumber) {
            biggerNumber();
        } else if (entryNumber < randomNumber) {
            smallerNumber();
        } else {
            equalsNumber();
        }

    }

    public abstract void biggerNumber();
    public abstract void smallerNumber();
    public abstract void equalsNumber();

}
