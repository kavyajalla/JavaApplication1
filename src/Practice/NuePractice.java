package Practice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class NuePractice {

}

interface Component {
	String getName();
	BigDecimal getPrice();
}

class Product implements Component {
	String name;
	BigDecimal price;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public BigDecimal getPrice() {
		return price;
	}
}

class Bundle implements Component {
	String name;
	double discountPercentage;
	List<Component> products;
	
	public void addProducts(Component p) {
		products.add(p);
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public BigDecimal getPrice() {
		BigDecimal total = BigDecimal.ZERO;
		for(Component p : products) {
			total = total.add(p.getPrice());
		}
		BigDecimal discount = total.multiply(BigDecimal.valueOf(discountPercentage));
		return total.subtract(discount);
	}
}

class ProrationEngine {
	
	public BigDecimal deltaCalculator(Component oldPlan, Component newPlan, LocalDate planChangeDate, LocalDate planEndDate) {
		long totalDaysInMonth = planChangeDate.lengthOfMonth();
		long remainingDays = ChronoUnit.DAYS.between(planEndDate, planChangeDate) + 1;
		
		//Gives price difference for entire plan period
		BigDecimal priceDifference = newPlan.getPrice().subtract(oldPlan.getPrice());
		
		BigDecimal dailyDelta = priceDifference.divide(BigDecimal.valueOf(totalDaysInMonth), 10, RoundingMode.HALF_UP);
		
		return dailyDelta.multiply(BigDecimal.valueOf(remainingDays)).setScale(2, RoundingMode.HALF_UP);
		
		//My code
//		int totalDaysInMonth = 31;
//		int reminaingDays = planEndDate.getDayOfMonth() - planChangeDate.getDayOfMonth();
//		
//		BigDecimal currentDailyRate = oldPlan.getPrice().divide(BigDecimal.valueOf(totalDaysInMonth));
//		BigDecimal newDailyRate = newPlan.getPrice().divide(BigDecimal.valueOf(totalDaysInMonth));
//		
//		BigDecimal currPlanAmount = currentDailyRate.multiply(BigDecimal.valueOf(reminaingDays));
//		BigDecimal newPlanAmount = newDailyRate.multiply(BigDecimal.valueOf(reminaingDays));
//		
//		return newPlanAmount.subtract(currPlanAmount);
	}
	
}

/*
 * The ChallengeA customer has a monthly subscription costing $300/month.The billing cycle is March 1st to March 31st (31 days).
 * On March 16th, they upgrade to a premium tier costing $600/month
 * .How do you calculate the "Delta" (the extra amount they owe) for the remainder of March?
 * 
 * 1. The Math LogicTo solve this, you need the "Daily Rate" for both plans.Unused portion of Old Plan: Days 16–31 (16 days remaining).
 * Used portion of New Plan: Days 16–31 (16 days).
 * The Formula: $$\text{Total Charge} = (\text{New Daily Rate} \times \text{Remaining Days}) - (\text{Old Daily Rate} \times \text{Remaining Days})$$
*/


