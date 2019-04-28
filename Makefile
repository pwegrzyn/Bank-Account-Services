init:
	pip install zeroc-ice

interface: interface/slice/bank.ice interface/proto/currency_service.proto
	bin/slice2java --output-dir interface/generated/ice/java interface/slice/bank.ice
	bin/slice2py --output-dir interface/generated/ice/python interface/slice/bank.ice
	bin/protoc --plugin=protoc-gen-grpc-java=bin/protoc-gen-grpcs-java-1.20.0-windows-x86_64.exe \
	--java_out=interface/generated/proto/java interface/proto/currency_service.proto
	
run_bank_client:
	python client/main.py

run_currency_service:
	cd ./currency_service; gradle run

run_bank_service:
	cd ./bank; gradle run