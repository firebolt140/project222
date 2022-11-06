//Christian Flores
//CDF200003

public class Player implements Comparable<Player> {

    //Declaring variables for player objects
    private String name;
    private double[] stats = new double[6];

    //Get name value
    public String getName(){
        return name;
    }

    //Set values for stats array
    public void setStats(String statsString){
        //Repeats for the amount of characters in each stat line
        for(int i = 0; i < statsString.length(); i++){
            //Creates a variable to hold each character in a given stat line
            char nextChar = statsString.charAt(i);

            //Checks the value of each character and does different actions based on its value
            switch(nextChar){
                case 'H': //If the character is 'H'
                    stats[0]++; //Increases the count of hits for a given player
                    break; //Leave switch statement

                case 'O': //If the character is 'O'
                    stats[1]++; //Increases the count of outs for a given player
                    break; //Leave switch statement

                case 'K': //If the character is 'K'
                    stats[2]++; //Increases the count of strikeouts for a given player
                    break; //Leave switch statement

                case 'W': //If the character is 'W'
                    stats[3]++; //Increases the count of walks for a given player
                    break; //Leave switch statement

                case 'P': //If the character is 'P'
                    stats[4]++; //Increases the count of hit by pitches for a given player
                    break; //Leave switch statement

                case 'S': //If the character is 'S'
                    stats[5]++; //Increases the count of sacrifices for a given player
                    break; //Leave switch statement

                default: //If the character is anything else, do nothing
                    break; //Leave switch statement
            }
        }
    }

    //Get stats from stats array and calculated stats
    public double getStats(int statToGet){
        switch(statToGet){
            //If the chosen stat is 0 return hits
            case 0:
                return stats[0];

            //If the chosen stat is 1 return outs
            case 1:
                return stats[1];

            //If the chosen stat is 2 return strikeouts
            case 2:
                return stats[2];

            //If the chosen stat is 3 return walks
            case 3:
                return stats[3];

            //If the chosen stat is 4 return hit by pitches
            case 4:
                return stats[4];

            //If the chosen stat is 5 return sacrifices
            case 5:
                return stats[5];

            //If the chosen stat is 6 return calculated batting average
            case 6:
                return battingAvg();

            //If the chosen stat is 7 return calculated on base percentage
            case 7:
                return onBasePerc();

            default:
                break;
        }
        return 0;
    }


    //Player constructor
    public Player(String newName){
        name = newName;
    }


    @Override //Overriding toString method for player objects to return formatted stats
    public String toString(){
        return String.format("%s\t%.0f\t%.0f\t%.0f\t%.0f\t%.0f\t%.0f\t%.3f\t%.3f", name, atBats(), stats[0], stats[3], stats[2], stats[4], stats[5], battingAvg(), onBasePerc());
    }

    //Method to calculate at-bats (hits + outs + strikeouts)
    public double atBats(){
        return (stats[0] + stats[1] + stats[2]);
    }
    //Method to calculate plate appearances (hits + outs + strikeouts + walks + hit by pitches + sacrifices)
    public double plateAppear(){
        return (stats[0] + stats[1] + stats[2] + stats[3] + stats[4] + stats[5]);
    }
    //Method to calculate batting average (hits / at-bats) and rounding to 3 decimals places
    public double battingAvg(){
        return (Math.round((stats[0] / atBats()) * 1000.0) / 1000.0);
    }
    //Method to calculate on-base percentage (hits + walks + hit by pitches) and rounding to 3 decimal places
    public double onBasePerc(){
        return (Math.round(((stats[0] + stats[3] + stats[4]) / plateAppear()) * 1000.0) / 1000.0 );
    }

    //Override compareTo method
    @Override
    public int compareTo(Player tempPlayer) {
        return name.compareTo(tempPlayer.name); //Compare player string names and return value the value of the comparison
    }
}
