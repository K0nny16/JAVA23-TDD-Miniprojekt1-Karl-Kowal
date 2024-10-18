public class PrimeNumbers {
    private int sum = 0;
    private int amountOfPrimes = 0;

    public void addNumbers(Integer start,Integer end) {
        //Kollar ifall något av värdena är null
        if(start == null || end == null) throw new NullPointerException("Range is null");
        if(end < 0 || start < 0) throw new IllegalArgumentException("Range is negative");
        for(int i = start; i <= end; i++){
            if(isPrime(i)){
                sum += i;
                amountOfPrimes+=1;
            }
        }
    }
    //Denna funktion är snabbare än den enklare Math.sqrt(number) ifall man rör sig med större tal.
    public boolean isPrime(int number){
        //Kollar om det är nummer 1 och returnerar då false eftersom 1 inte är ett primtal.
        if(number <= 1) return false;
        //Kollar om det är nummer 2 eller 3 vilket båda är primtal.
        if(number == 2 || number == 3) return true;
        //Tarbort alla udda och jämna nummer som inte är primtal.
        if(number % 2 == 0 || number % 3 == 0) return false;
       /*Vi börjar på 5 eftersom att vi har redan testat mot dom primtal som finns innan 5 (2 och 3).
       * För varje i kontrollerar vi ifall kontrollerar vi ifall number är delbart med i eller i + 2.
       * Exempel: När i = 5 kontrollerar vi 5 och 7 när i = 11 kontrollerar vi 11 och 13 detta gör att vi täcker fler primtal snabbare.
       * Genom att öka med 6 hoppar vi direkt till nästa grupp med möjliga primtal så vi skippar udda tal som inte är primtal.
       * Detta funkar eftersom att primtal har ett mönster där alla primtal som är större än 3 kan skrivas som 6k + 1 eller 6k - 1
       * Varför vi multiplicerar i med i är för att vi behöver bara kontrollerar faktorer upp till roten av talet.
       * Vi stannar på kvadrat roten eftersom att ifall det är delbart med ett större tal så hade det också varit delbart med ett mindre. (Förutom number)
       * Och när då i*i har större kvadratrot än number så slutar loopen.
       * */
        for(int i = 5; i * i <= number; i+=6){
            //Kontrollerar ifall talet är delbart med något av talen t.ex (5,11,17)
            //Eller i +2 delen t.ex (7,13,19)
            //Dubble kollen som jag nämde ovan.
            if(number % i == 0 || number % (i + 2) == 0) return false;
        }
        return true;
    }
    public void printCount(){
        System.out.println("Amount of primes in range is: "+amountOfPrimes);
    }
    public void printSum(){
        System.out.println("Sum is: "+sum);
    }
    public int getSum() {
        return sum;
    }
    public int getAmountOfPrimes() {
        return amountOfPrimes;
    }
}
