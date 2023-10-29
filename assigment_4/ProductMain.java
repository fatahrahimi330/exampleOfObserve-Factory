interface Product {
    String create();
}

class ConcreteProductA implements Product {

    @Override
    public String create() {
        return "Product A";
    }
}

class ConcreteProductB implements Product {

    @Override
    public String create() {
        return "Product B";
    }
}

abstract class Creator {

    public abstract Product factoryMethod();

    public Product createProduct() {
        return factoryMethod();
    }
}

class ConcreteCreatorA extends Creator {

    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}

class ConcreteCreatorB extends Creator {

    @Override
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}

public class ProductMain {

    public static void main(String[] args) {
        Creator creatorA = new ConcreteCreatorA();
        Product productA = creatorA.createProduct();
        System.out.println(productA.create()); // Output: "Product A"

        Creator creatorB = new ConcreteCreatorB();
        Product productB = creatorB.createProduct();
        System.out.println(productB.create()); // Output: "Product B"
    }
}

// We use the Factory pattern in the Product example because it allows us to
// decouple the creation of products from their usage. This makes the code more
// flexible and maintainable.

// Without the Factory pattern, we would need to instantiate concrete product
// classes directly in our code. This would mean that we would need to know the
// specific type of product that we want to create at compile time. This could
// be limiting and error-prone.

// With the Factory pattern, we can create products without having to know their
// concrete type. This is because the Factory pattern abstracts away the
// creation logic of the products. Instead, we can simply call the
// factoryMethod() method on a creator object to create a product.

// Here are some specific benefits of using the Factory pattern in the Product
// example:

// Flexibility: We can change the type of product that is created without having
// to modify the code of the clients. This is because the clients only need to
// know about the abstract Product interface.
// Maintainability: The code is easier to maintain because the creation logic of
// the products is centralized in the creator classes.
// Reusability: We can reuse the Factory pattern in other parts of our codebase.
// Overall, the Factory pattern is a powerful design pattern that can be used to
// decouple the creation of objects from their usage. This makes the code more
// flexible, maintainable, and reusable.

// In addition to the above benefits, the Factory pattern can also be used to:

// Hide the implementation details of the concrete product classes. This can
// make the code more modular and easier to understand.
// Provide a central location to manage the creation of products. This can make
// the code more reusable and easier to maintain.
// Create different types of products based on different criteria. For example,
// we could create a factory that creates different types of products based on
// the user's preferences.
// Overall, the Factory pattern is a versatile and powerful design pattern that
// can be used to improve the flexibility, maintainability, and reusability of
// code.