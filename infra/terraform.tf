terraform {

  required_version = ">=0.12"

  backend "azurerm" {
    resource_group_name  = "tamopstfstates"
    storage_account_name = "tamopstf22"
    container_name       = "tfstatedevops"
    key                  = "tamopstfstates.tfstate"
  }
  required_providers {
    azurerm = {
      source = "hashicorp/azurerm"
      version = "~>2.0"
    }
  }
}
