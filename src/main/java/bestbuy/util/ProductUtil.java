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

    private BestBuyLinkedList<Product> searchByProductName(String searchCriteria){
        BestBuyLinkedList<Product> searchResultsBasedOnName = new BestBuyLinkedList<>();
        for(Product productToSearch: productsArray){
            if(productToSearch.getProductName()!=null && productToSearch.getProductName().toLowerCase().contains(searchCriteria.toLowerCase())) {
                searchResultsBasedOnName.insert(productToSearch);
            }
        }
        return searchResultsBasedOnName;
    }

    private BestBuyLinkedList<Product> searchProductBySubCategory(String productSearchCriteria){
        int indexOfSearch = binarySearchProduct(productSearchCriteria);
       BestBuyLinkedList<Product> searchResultsForProducts = new BestBuyLinkedList<>();
        if(indexOfSearch!=-1){
            //if it is the last index , search backwards for multiple records
            if(indexOfSearch==(productsArray.length-1)){
                searchResultsForProducts.insert(productsArray[indexOfSearch]);
                indexOfSearch=-1;
                while(indexOfSearch>=0 && productsArray[indexOfSearch].getProductSubCategory().equalsIgnoreCase(productSearchCriteria)){
                   searchResultsForProducts.insert(productsArray[indexOfSearch]);
                   indexOfSearch-=1;
                }
         }else{
                searchResultsForProducts.insert(productsArray[indexOfSearch]);
                int positiveTraverseIndex = indexOfSearch+1;
                int negativeTraverseIndex = indexOfSearch-1;
                while(negativeTraverseIndex>=0 && productsArray[negativeTraverseIndex].getProductSubCategory().equalsIgnoreCase(productSearchCriteria)){
                     searchResultsForProducts.insert(productsArray[negativeTraverseIndex]);
                     negativeTraverseIndex-=1;
                }
                while(positiveTraverseIndex<productsArray.length && productsArray[positiveTraverseIndex].getProductSubCategory().equalsIgnoreCase(productSearchCriteria)){
                    searchResultsForProducts.insert(productsArray[positiveTraverseIndex]);
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

            int res = productSearchCriteria.compareTo(productsArray[m].getProductSubCategory());

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


    public static void main(String[] args) {
        Product p1 = new Product();
        p1.setProductID("1");
        p1.setProductSubCategory("Furniture");
        Product p2 = new Product();
        p2.setProductID("2");
        p2.setProductSubCategory("Laptop");
        Product p3 = new Product();
        p3.setProductID("3");
        p3.setProductSubCategory("Laptop");
        Product p4 = new Product();
        p4.setProductID("4");
        p4.setProductSubCategory("Laptop");
        Product p5 = new Product();
        p5.setProductName("Stradyvirus voilin");
        p5.setProductID("5");
        p5.setProductSubCategory("Voilins");
        productsArray = new Product[5];
        productsArray[0]=p1;
        productsArray[1]=p2;
        productsArray[2]=p3;
        productsArray[3]=p4;
        productsArray[4]=p5;
        ProductUtil productUtil = new ProductUtil();
        BestBuyLinkedList<Product> searchResults = productUtil.searchByProductName("Stradyvirus");
        searchResults.show();


    }
}
