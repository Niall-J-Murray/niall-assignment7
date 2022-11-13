package niall.assignment7.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CustomArrayListTest {

	@Test
	void should_add_one_item_to_list() {
		CustomArrayList<Object> sut = new CustomArrayList<>();

		sut.add(10);

		assertEquals(10, sut.get(0));
		assertEquals(1, sut.getSize());
	}

	@Test
	void should_double_array_capacity_when_full() {
		CustomArrayList<Object> sut = new CustomArrayList<>();

		int currentCapacity = sut.items.length;
		for (int i = 0; i < currentCapacity + 1; i++) {
			sut.add(i);
		}

		int doubledCapacity = sut.items.length;

		assertEquals(doubledCapacity, (currentCapacity * 2));

	}

	@Test
	void should_increase_capacity_to_20_and_add_13_items() {
		CustomArrayList<Object> sut = new CustomArrayList<>();

		for (int i = 1; i <= 13; i++) {
			sut.add(i);
		}

		for (int i = 0; i < 12; i++) {
			assertEquals(i + 1, sut.get(i));
		}

		assertEquals(20, sut.items.length);
		assertEquals(13, sut.getSize());

	}

	@Test
	void should_increase_capacity_to_80_and_add_42_items() {
		CustomArrayList<Object> sut = new CustomArrayList<>();

		for (int i = 1; i <= 42; i++) {
			sut.add(i);

		}
		for (int i = 0; i < 41; i++) {
			assertEquals(i + 1, sut.get(i));
		}

		assertEquals(80, sut.items.length);
		assertEquals(42, sut.getSize());
	}

	@Test
	void should_add_item_at_specified_index() {
		CustomArrayList<Object> sut = new CustomArrayList<>();

		for (int i = 0; i <= 17; i++) {
			sut.add(i);
		}
		sut.add(7, 23);

		assertEquals(23, sut.get(7));
		assertEquals(15, sut.get(16));
		assertEquals(19, sut.getSize());
	}

	@Test
	void should_return_number_of_elements_in_list() {
		CustomArrayList<Object> sut = new CustomArrayList<>();

		for (int i = 0; i <= 32; i++) {
			sut.add(i);
		}

		assertEquals(33, sut.getSize());
	}

	@Test
	void should_return_object_at_index_passed() {
		CustomArrayList<Object> sut = new CustomArrayList<>();

		for (int i = 0; i <= 28; i++) {
			sut.add(i);
		}

		assertEquals(16, sut.get(16));
	}

	@Test
	void should_remove_item_at_index_passed() {
		CustomArrayList<Object> sut = new CustomArrayList<>();

		for (int i = 0; i <= 21; i++) {
			sut.add(i);
		}

		assertEquals(9, sut.remove(9));
		assertEquals(21, sut.getSize());
	}

	@Test
	void should_throw_IndexOutOfBoundsException_if_out_of_range() {
		CustomArrayList<Object> sut = new CustomArrayList<>();

		for (int i = 0; i <= 25; i++) {
			sut.add(i);
		}

		assertThrows(IndexOutOfBoundsException.class,
				() -> {
					sut.get(-2);
				});
		assertThrows(IndexOutOfBoundsException.class,
				() -> {
					sut.get(27);
				});
		assertThrows(IndexOutOfBoundsException.class,
				() -> {
					sut.add(28, 5);
				});
		assertThrows(IndexOutOfBoundsException.class,
				() -> {
					sut.remove(29);
				});
	}
}
