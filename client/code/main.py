
import client
import sys

if __name__ == '__main__':
    app = client.ClientApp()
    sys.exit(app.main(sys.argv, "./client/code/config.client"))
