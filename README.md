# BankAccountService
Bank Account Service (ICE/gRPC and Python/Java) project for Distributed Systems class at AGH-UST

## Getting Started

This system contains three main components: the bank system (Java), the bank client (Python)
and the currency service (Java). 

### Prerequisites

The project was tested on this stack:
* Gradle 5.0
* Java 1.8+
* Python 3.7
* pip 18.1
* make 3.81
* WSL (bash)


### Running

To run the project just use the provided Makefile:

Run required initialisation steps
```
make init
```

Run the bank application:
```
make run_bank_service
```

Generate middleware interfaces:
```
make interface
```

See Makefile for more details
