package coffee;

import dagger.Lazy;
import javax.inject.Inject;

class CoffeeMaker {
  @Inject Lazy<Heater> heater; // Don't want to create a possibly costly heater until we need it.
  @Inject Pump pump;

  public void brew() {
    heater.get().on();
    pump.pump();
    System.out.println(" [_]P coffee! [_]P ");
    heater.get().off();
  }


  //这个类有fields注入（heater，pump）
  //所以这个无参数的公有构造函数的@Inject可以省略
  //原话 A class may have a single
  // *       {@code @Inject}-annotated constructor. Classes that have fields
  // *       injected may omit the {@code @Inject} annotation if they have a public
  // *       no-arguments constructor.
//  @Inject
//  public CoffeeMaker(){
//  }
}
