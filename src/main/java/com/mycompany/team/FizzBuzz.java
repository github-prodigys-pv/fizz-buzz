
package com.mycompany.team;


class FizzBuzz {    
    
    String execute(int i) {
        if (i < 0) throw new IllegalArgumentException("Il numero deve essere maggiore di zero");
        else if ((i % 3 == 0) && (i % 5 == 0) ) return "Fizz Buzz";
        else if (i % 3 == 0) return "Fizz";
        else if (i % 5 == 0) return "Buzz";
        else  return String.valueOf(i);
    }
    
}
