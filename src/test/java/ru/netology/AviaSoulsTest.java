package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Москва", "Екатеринбург", 3500, 5, 6);
    Ticket ticket2 = new Ticket("Москва", "Новосибирск", 5000, 6, 8);
    Ticket ticket3 = new Ticket("Москва", "Екатеринбург", 4300, 7, 9);
    Ticket ticket4 = new Ticket("Москва", "Новосибирск", 4600, 8, 11);
    Ticket ticket5 = new Ticket("Москва", "Екатеринбург", 4000, 9, 10);
    Ticket ticket6 = new Ticket("Москва", "Ижевск", 3500, 10, 11);

    @Test
    public void shouldComparePrice1() {
        AviaSouls manager = new AviaSouls();
        int expected = -1;
        int actual = ticket1.compareTo(ticket3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldComparePrice2() {
        AviaSouls manager = new AviaSouls();
        int expected = 1;
        int actual = ticket2.compareTo(ticket3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldComparePrice3() {
        AviaSouls manager = new AviaSouls();
        int expected = 0;
        int actual = ticket1.compareTo(ticket6);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearch0() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Ticket[] expected = {};
        Ticket[] actual = manager.search("Москва", "Пермь");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearch1() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Ticket[] expected = {ticket6};
        Ticket[] actual = manager.search("Москва", "Ижевск");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearch2() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Ticket[] expected = {ticket4, ticket2};
        Ticket[] actual = manager.search("Москва", "Новосибирск");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearch3() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Ticket[] expected = {ticket1, ticket5, ticket3};
        Ticket[] actual = manager.search("Москва", "Екатеринбург");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByTime0() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSortBy("Москва", "Пермь", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByTime1() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket[] expected = {ticket6};
        Ticket[] actual = manager.searchAndSortBy("Москва", "Ижевск", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByTime2() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket[] expected = {ticket2, ticket4};
        Ticket[] actual = manager.searchAndSortBy("Москва", "Новосибирск", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByTime3() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket[] expected = {ticket1, ticket5, ticket3};
        Ticket[] actual = manager.searchAndSortBy("Москва", "Екатеринбург", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }
}