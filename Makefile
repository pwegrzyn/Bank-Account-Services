init:
	pip install zeroc-ice

interface: interface/slice/bank.ice interface/proto/currency_service.proto
	bin/slice2java --output-dir interface/generated/ice/java interface/slice/bank.ice
	bin/slice2py --output-dir interface/generated/ice/python interface/slice/bank.ice
	cp -r interface/generated/ice/java/* bank/src/generated/main/java/
	cp -r interface/generated/ice/python/* client/generated/
	rm -rf interface/generated/ice/java/*
	rm -rf interface/generated/ice/python/*
	cp interface/proto/currency_service.proto bank/src/main/proto/currency_service.proto
	cd ./bank; gradle generateProto --console=plain
	cp interface/proto/currency_service.proto currency_service/src/main/proto/currency_service.proto
	cd ./currency_service; gradle generateProto --console=plain
	
run_bank_client:
	python client/code/main.py

run_currency_service:
	cd ./currency_service; gradle run --console=plain

run_bank_service:
	cd ./bank; gradle run --console=plain