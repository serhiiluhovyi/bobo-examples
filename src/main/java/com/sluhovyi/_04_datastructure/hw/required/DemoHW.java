package com.sluhovyi._04_datastructure.hw.required;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

public class DemoHW {

  public static void main(String[] args) {
    List<Account> accounts = generateAccountList(16);
//    System.out.println(accounts);
    var emailToBirthdayTable = new HashTable<String, LocalDate>();
    accounts.forEach(a -> emailToBirthdayTable.put(a.getEmail(), a.getBirthday()));
    emailToBirthdayTable.printTable();
    System.out.println("\nSIZE: " + emailToBirthdayTable.getSize());

    Account newAcc = new Account(accounts.get(0).getEmail(), LocalDate.now());
    System.out.println("\n" + newAcc);
    emailToBirthdayTable.put(newAcc.getEmail(), newAcc.getBirthday());
    emailToBirthdayTable.printTable();
    System.out.println("\nSIZE: " + emailToBirthdayTable.getSize());

    Account newOneAcc = new Account("qwerty@gmail.com", LocalDate.now());
    System.out.println("\n" + newOneAcc);
    emailToBirthdayTable.put(newOneAcc.getEmail(), newOneAcc.getBirthday());
    emailToBirthdayTable.printTable();
    System.out.println("\nSIZE: " + emailToBirthdayTable.getSize());
  }

  @Data
  @AllArgsConstructor
  @EqualsAndHashCode(of = "email")
  static class Account {

    private String email;
    private LocalDate birthday;
  }

  public static List<Account> generateAccountList(int size) {
    List<Account> accounts = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      Person person = generatePerson();
      Account account = new Account(person.getEmail(), LocalDate.of(
          person.getDateOfBirth().getYear(),
          person.getDateOfBirth().getMonth(),
          person.getDateOfBirth().getDayOfMonth()));
      accounts.add(account);
    }
    return accounts;
  }

  private static Person generatePerson() {
    Fairy fairy = Fairy.create();
    return fairy.person();
  }

}
