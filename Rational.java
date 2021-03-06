//Anya Hargil
//pd 9
//HW27
//2013-11-18

public class Rational{

  /*======================================================================================
  Instance variables for the numerator and denominator
  ======================================================================================*/
  private int _num, _den;
  
  /*======================================================================================
  Default constructor (no parameters)
  Creates a new Rational with the value of 0/1
  ======================================================================================*/
  
  public Rational() {
    _num = 0;
    _den = 1;
  }
  
  /*======================================================================================
  Constructor
  takes 2 parameters, one for the numerator, one for the denominator
  if an invalid denominator is attempted, should print a message and set the number to 0/1
  ======================================================================================*/
  
  public Rational(int num, int den) {
    if (den == 0) {
      System.out.println("Zero is an invalid denomenator");
      _num = 0;
      _den = 1;
    }
    else {
      _num = num;
      _den = den;
    }
  }
  
  /*=======================================================================================
  toString
  returns a string representation of the rational number (formatting of your choice)
  =======================================================================================*/
  
  public String toString() {
    String ret = "";
    ret += _num;
    ret += "/";
    ret += _den;
    return ret; 
  }
  
  /*========================================================================================
  floatValue
  Returns a floating point value of the number
  Uses the most precise floating point primitive
  ========================================================================================*/
  
  public double floatValue() {
    double flo = (double)_num/_den;
    return flo;
  }
  
  /*========================================================================================
  multiply
  Takes 1 Rational object as a parameter and multiplies it by this Rational object 
  Does not return any value
  Should modify this object and leave the parameter alone (see below for example) 
  Need not reduce the fraction
  ========================================================================================*/
  
  public void multiply(Rational rat) {
    this._num *= rat._num;
    this._den *= rat._den;
  }
  
  /*========================================================================================
  divide
  Works the same as multiply, except the operation is division
  ========================================================================================*/
  
  public void divide(Rational rat) {
    this._num *= rat._den;
    this._den *= rat._num;
  }
  
  /*========================================================================================
  add
  Takes 1 Rational object (just like multiply) and adds it to the current rational number object
  Need not reduce
  ========================================================================================*/
  
  public void add(Rational rat) {
    this._num = this._num * rat._den + rat._num * this._den;
    this._den *= rat._den;
  }
  
  /*========================================================================================
  subtract
  Works the same as add, except the operation is subtraction
  ========================================================================================*/
  
  public void subtract(Rational rat) {
    this._num = this._num * rat._den - rat._num * this._den;
    this._den *= rat._den;
  }
  
  /*========================================================================================
  gcd
  Returns the gcd of the numerator and denominator
  Uses Euclid's algorithm (reuse your old code!)
  Recall that in order for Euclid's algorithm to work, the first number must be greater than the second
  ========================================================================================*/
  
  public int gcd() {
      return gcd(_num, _den);
  }
  
  /*========================================================================================
  reduce
  Changes this Rational to one in reduced form (should use gcd)
  ========================================================================================*/
  
  public void reduce() {
    int gcd = this.gcd();
    this._num /= gcd;
    this._den /= gcd;
  }
  
  /*========================================================================================
  Add a static gcd method that will take numerator and denominator inputs.
  ========================================================================================*/
  
  public static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    else {
      return gcd(b, a % b);
    }
  }
  
  /*========================================================================================
  Add a method called compareTo that...
  Takes a Rational as a parameter and compares it to the calling object
  Returns 0 if the two numbers are equal
  Returns a positive integer if the calling number is larger than the parameter
  Returns a negative integer if the calling number is smaller than the parameter
  ========================================================================================*/
  
  public int compareTo(Rational rat) {
      Integer x = this._num * rat._den;
      Integer y = this._den * rat._num;
      return x.compareTo(y);
  }
  
  /*========================================================================================
  equals
  Overrides equals method inherited from Object superclass
  ========================================================================================*/
  
  public boolean equals(Rational rat) {
    return this.compareTo(rat) == 0;
  }
  
  public static void main( String[] args ) {
    Rational q = new Rational();
    Rational r = new Rational(2,3); //Stores the rational number 2/3
    Rational s = new Rational(1,2); //Stores the rational number 1/2
    System.out.println("The rational number q is " + q);
    System.out.println("The rational number r is " + r);
    System.out.println("The rational number s is " + s);
    System.out.print(r + " times " + s + " is "); 
    r.multiply(s); //Multiplies r by s, changes r to 2/6.  s remains ½
    System.out.println(r);
    System.out.print(r + " divided by " + s + " is ");
    r.divide(s); //Divides r by s, changes r to 4/6.  s remains ½
    System.out.println(r);
    System.out.println("In decimal form " + r + " is " + r.floatValue());
    System.out.println("In decimal form " + s + " is " + s.floatValue());
    System.out.print(r + " plus " + s + " is "); 
    r.add(s); //Adds r to s, changes r to 14/12.  s remains ½
    System.out.println(r);
    System.out.print(r + " minus " + s + " is ");
    r.subtract(s); //Subtracts s from r, changes r to 16/24.  s remains ½
    System.out.println(r);
    System.out.println("The greastest common factor of " + r._num + " and " + r._den + " is " + r.gcd());
    System.out.print("The reduced form of " + r + " is ");
    r.reduce();
    System.out.println(r);
    System.out.println(r.compareTo(s));
    System.out.println(s.compareTo(r));
    System.out.println(s.compareTo(s));
  }
}
