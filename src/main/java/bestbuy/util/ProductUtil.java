package bestbuy.util;

import bestbuy.model.BestBuyLinkedList;
import bestbuy.model.Product;

public class ProductUtil {
  static Product[] productsArray;
    public void listProducts(){
        productsArray = readProductsFile();

    }
    private Product[] readProductsFile() {
        return new Product[]{new Product()};
    }

    private BestBuyLinkedList<Product> searchProduct(String productSearchCriteria){
        int indexOfSearch = binarySearchProduct(productSearchCriteria);
       BestBuyLinkedList<Product> searchResultsForProducts = new BestBuyLinkedList<>();
        if(indexOfSearch!=-1){
            //if it is the last index , search backwards for multiple records
            if(indexOfSearch==(productsArray.length-1)){
                searchResultsForProducts.insert(productsArray[indexOfSearch]);
                indexOfSearch=-1;
                while(indexOfSearch>=0 && productsArray[indexOfSearch].getSubCategory().equalsIgnoreCase(productSearchCriteria)){
                   searchResultsForProducts.insert(productsArray[indexOfSearch]);
                   indexOfSearch-=1;
                }
         }else{
                searchResultsForProducts.insert(productsArray[indexOfSearch]);
                int positiveTraverseIndex = indexOfSearch+1;
                int negativeTraverseIndex = indexOfSearch-1;
                while(negativeTraverseIndex>=0 && productsArray[indexOfSearch].getSubCategory().equalsIgnoreCase(productSearchCriteria)){
                     searchResultsForProducts.insert(productsArray[indexOfSearch]);
                     negativeTraverseIndex-=1;
                }
                while(positiveTraverseIndex<productsArray.length && productsArray[indexOfSearch].getSubCategory().equalsIgnoreCase(productSearchCriteria)){
                    searchResultsForProducts.insert(productsArray[indexOfSearch]);
                    positiveTraverseIndex+=1;
                }
         }
        }
        return searchResultsForProducts;
    }

    private int binarySearchProduct(String productSearchCriteria){
        int l = 0, r = productsArray.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            int res = productSearchCriteria.compareTo(productsArray[m].getProductCategory());

            // Check if x is present at mid
            if (res == 0)
                return m;

            // If x greater, ignore left half
            if (res > 0)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        return -1;
    }
}
