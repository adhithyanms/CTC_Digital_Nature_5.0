public class Main {


    public static void main(String args[]){



        // Normal array

        Product products[] = {


                new Product(101,"Mobile","Electronics"),

                new Product(105,"Shoes","Fashion"),

                new Product(103,"Laptop","Electronics"),

                new Product(102,"Watch","Accessories"),

                new Product(104,"Camera","Electronics")

        };



        System.out.println("Linear Search");


        Product result = LinearSearch.search(products,104);


        if(result != null){

            result.display();

        }

        else{

            System.out.println("Product Not Found");

        }




        // Sorted array for Binary Search


        Product sortedProducts[] = {


                new Product(101,"Mobile","Electronics"),

                new Product(102,"Watch","Accessories"),

                new Product(103,"Laptop","Electronics"),

                new Product(104,"Camera","Electronics"),

                new Product(105,"Shoes","Fashion")

        };



        System.out.println("Binary Search");


        Product result2 =
                BinarySearch.search(sortedProducts,104);



        if(result2 != null){

            result2.display();

        }

        else{

            System.out.println("Product Not Found");

        }


    }

}