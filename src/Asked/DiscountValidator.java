package Asked;



import java.io.*;
import java.util.*;

public class DiscountValidator {
    
    /// <summary>
    /// Determines whether or not a list of assignment discounts are valid
    /// </summary>
    /// <param name="assignedDiscounts">collection of DiscountAssignments that contain a mapping between DiscountId and CustomerId</param>
    /// <param name="customers">A collection of customers of the super store</param>
    /// <param name="discounts">A collection of discounts that are available to offer to customers of the super store</param>
    /// <returns><c>Boolean</c> Determines whether or not it is a valid assignment of discounts to customers</returns>
    /// <remarks>
    public static boolean validateDiscounts(List<DiscountAssignment> assignedDiscounts, List<Customer> customers, List<Discount> discounts) {
      // solution goes here
      
      Map<Integer, List<Integer>> custDisc = new HashMap();
      Set<Integer> allDiscs = new HashSet();
      Map<Integer, Float> custMap = new HashMap();
      Map<Integer, Float> discMap = new HashMap<>();
      Map<Integer, Float> finalMap = new HashMap();
      
      for(int i=0; i<customers.size(); i++)
      {
        custMap.put(customers.get(i).getCustomerId(), customers.get(i).getYearlySpend());
      }
      
      for(int i=0; i<discounts.size(); i++)
      {
        discMap.put(discounts.get(i).getDiscountId(), discounts.get(i).getDollarValue());

      }
      
      Collections.sort(customers, (a,b) -> Float.compare(a.getYearlySpend(), b.getYearlySpend()));

      
      for(int i=0;i<assignedDiscounts.size(); i++)
      {
        int custId = assignedDiscounts.get(i).getCustomerId();
        int discId = assignedDiscounts.get(i).getDiscountId();
        float yearlySpend = custMap.get(custId);
        float dollarValue = discMap.get(discId);
        float discValue = 0;
        
        allDiscs.add(discId);
        
        float total = 0;

        if(custDisc.containsKey(custId))
        {
            List<Integer> discs = custDisc.get(custId);
            if(discs.size()==3)
            {
                return false;
            }
            
            discs.add(discId);
            custDisc.put(custId, discs);
            for(int j=0; j<discs.size(); j++)
            {
                total += discMap.get(discs.get(i));
            }
            if(total > yearlySpend*0.2)
            {
                return false;
            }
        }
        else
        {
            List<Integer> discs = new ArrayList<>();
            discs.add(discId);
            custDisc.put(custId, discs);
            total = dollarValue;
            if(total > yearlySpend*0.2)
            {
                return false;
            }
        }
        
        finalMap.put(custId, total);
      }
      
      
      float prev = finalMap.get(customers.get(0).getCustomerId());
      
      for(int i=1; i<customers.size(); i++)
      {
        float curr = finalMap.get(customers.get(i).getCustomerId());
        if(curr>prev)
        {
            return false;
        }
        prev = curr;
      }
      
      if(allDiscs.size() != discounts.size())
      {
        return false;
      }

      return true;
    }
    
    
    static class Customer {
        private int customerId;
        private float yearlySpend;

        public Customer(int customerId, float yearlySpend) {
            this.customerId = customerId;
            this.yearlySpend = yearlySpend;
        }

        public int getCustomerId() {
            return customerId;
        }

        public float getYearlySpend() {
            return yearlySpend;
        }
    }

    static class Discount {
        private int discountId;
        private int productId;
        private float dollarValue;

        public Discount(int discountId, int productId, float value) {
            this.discountId = discountId;
            this.productId = productId;
            this.dollarValue = value;
        }

        public int getDiscountId() {
            return discountId;
        }

        public int getProductId() {
            return productId;
        }

        public float getDollarValue() {
            return dollarValue;
        }
    }

    static class DiscountAssignment {
        private int discountId;
        private int customerId;

        public DiscountAssignment(int discountId, int customerId) {
            this.discountId = discountId;
            this.customerId = customerId;
        }

        public int getDiscountId() {
            return discountId;
        }

        public int getCustomerId() {
            return customerId;
        }
    }
    
    /* Do not modify the main method, this is just IO setup for running test cases */
     public static void main(String[] args)
     {
        Scanner scanner = new Scanner(System.in);
        boolean isCustomer = false;
        boolean isDiscount = false;
        
        List<DiscountAssignment> assignedDiscounts = new ArrayList<DiscountAssignment>();
        List<Customer> customers = new ArrayList<Customer>();
        List<Discount> discounts = new ArrayList<Discount>();
        while (scanner.hasNextLine()) {
            String arg = scanner.nextLine();
            if (arg.equals("discountAssignment")) {
                continue;
            }
            
            if (arg.equals("customer")) {
                isCustomer = true;
                continue;
            }
            
            if (arg.equals("discount")) {
                isCustomer = false;
                isDiscount = true;
                continue;
            }
            
            if (!isCustomer && !isDiscount) {
                int[] values = splitStr(arg);
                assignedDiscounts.add(new DiscountAssignment(values[0], values[1]));
            }
            else if (isCustomer) {
                int[] values = splitStr(arg);
                customers.add(new Customer(values[0], values[1]));
            }
            else if (isDiscount) {
                int[] values = splitStr(arg);
                discounts.add(new Discount(values[0], 0, (float)values[1]));
            }
        }
        
        System.out.println(validateDiscounts(assignedDiscounts, customers, discounts));
    }
    
    private static int[] splitStr(String arg) {
        String[] splitString = arg.split(",");
        int[] nums = new int[2];
        for (int i = 0; i < 2; i++) {
            nums[i] = Integer.parseInt(splitString[i].trim());
        }
        
        return nums;
     }
}

/**
Draftkings - round 1 - Dec 12 2025

a big box super store. After a successful year, it is your job to help reward our best customers with some discounts. In order to do so, we must validate that the discounts we have assigned to our customers are fair
and valid.
You are given a list of
DiscountAssignments that maps a Discountld to a Customerld.
You are also given a list of all Discounts that can be assigned to Customers and a list of all Customers that can have Discounts assigned to them.
All Discounts will have a unique Discountld and all Customers will have a unique Customerld. There will be no duplicated Discounts or Customers in their respective lists.
A customer can have multiple discounts assigned to them and the same Discount can be given to multiple customers.
We must validate that:
1. No Customer has more than 3 discounts assigned to them
2. Every discount must be assigned to at least one customer
3. No Customer can have a total discount value more than 20% of their yearly spend 4. Customers must have a higher total discount value than other customers with lower yearly spends
Example of 4.
Spend by customer:
A: $100
B: $200
Java 8
67
68
69
70
71
72
73
74
75
76
77
78
79
80
81
82
83
84
85
86
87
88
89
90
91
92
93
94
95
96
97
98
99
100
101
102
103
C: $300
Total discount value requirements C > B > A
Line: 77 Col: 7
*/