//package geeksforgeeks.week4;
//
//public class DependencyInjection {
//
//    private Car car;
//
//    public DependencyInjection(Car car) {
//        this.car = car;
//    }
//
//    public void myMethod() {
//        System.out.println (car.fejhdfiehdu);
//    }
//
//}
//
//
////// Without DI
////class Car {
////
////    private Engine engine;
////
////    public Car() {
////        this.engine = new Engine ();
////    }
////
////} // XYZ -> E-XYZ
//// @Autowired
//class Engine { }
//
//class Door {}
//
//class Sunroof {}
//
//class Wheel {
//    // rubber
//    // axle -> steel -> paint
//}
//
//class Tyre {}
//
//// With DI
//// 3 ways. (1 way is Spring specific)
//
//// 1. Constructor Injection
//class Car {
//    private Engine engine;
//    private Wheel w1;
//    private Wheel w2;
//    private Wheel w3;
//    private Wheel w4;
//
//    private Sunroof sunroof;
//    private Door d1;
//    private Door d2;
//    private Door d3;
//    private Door d4;
//    private Door dikky;
//    private Door bonut;
//
//    @Autowried
//    public Car(Engine engine, Wheel w1, Wheel w2, Wheel w3, Wheel w4,
//               Sunroof sunroof,
//               Door d1, Door d2, Door d3, Door d4, Door dikky, Door bonut) {
//        this.engine = engine;
//        this.w1 = w1;
//        this.w2 = w2;
//        this.w3 = w3;
//        this.w4 = w4;
//        this.sunroof = sunroof;
//        this.d1 = d1;
//        this.d2 = d2;
//        this.d3 = d3;
//        this.d4 = d4;
//        this.dikky = dikky;
//        this.bonut = bonut;
//    }
//}
//
//class Car {
//
//    private Engine engine;
//
////    @Autowired
////    public void setEngine(Engine engine) {
////        this.engine = engine;
////    }
//}
//
//// @Bean
//// AWS aws

// 1. By using XML - 0.00001% will use it (we wont use this in future)
// 2. Using Annotations ✅✅