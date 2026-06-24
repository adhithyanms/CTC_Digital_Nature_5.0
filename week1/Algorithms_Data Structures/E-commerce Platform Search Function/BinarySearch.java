public class BinarySearch {


    public static Product search(Product products[], int id){


        int start = 0;

        int end = products.length-1;



        while(start <= end){


            int mid = (start + end)/2;



            if(products[mid].productId == id){

                return products[mid];

            }


            else if(id > products[mid].productId){


                start = mid + 1;

            }


            else{


                end = mid -1;

            }


        }


        return null;

    }

}