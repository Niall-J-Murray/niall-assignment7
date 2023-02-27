package niall.assignment7.main;

import java.util.Random;

public class CustomListApplication {

	public static void main(String[] args) {
		new CustomListApplication().customArrayListTester();
	}

	private void customArrayListTester() {
		Random random = new Random();
		Integer numberOfElements = random.nextInt(50);
		Object objectElement = "object";
		CustomArrayList<Object> customObjectList = new CustomArrayList<>();

		numberOfElements = random.nextInt(50);
		System.out.println("CustomArrayList<Object> test: ");
		objectListTest(customObjectList, objectElement, numberOfElements);

	}

	private void objectListTest(CustomArrayList<Object> customObjectList, Object objectElement, Integer numberOfElements) {
		Integer count = 0;
		while (count < numberOfElements) {
			customObjectList.add(objectElement + String.valueOf(count));
			count++;
		}

		printCustomArrayList(customObjectList, count);
		customObjectList.add(5, "Test Object");
		count++;
		System.out.println("'Test Object' added at index " + 5);
		printCustomArrayList(customObjectList, count);
		customObjectList.remove(5);
		count--;

		printCustomArrayList(customObjectList, count);

	}

	private void printCustomArrayList(CustomArrayList<Object> customObjectList, Integer count) {
		for (int i = 0; i < customObjectList.getSize(); i++) {
			System.out.println(customObjectList.get(i));
		}
		System.out.println("Items added = " + count);
		System.out.println("CustomArray size = " + customObjectList.getSize());
		System.out.println("------------------------------");
	}
}
