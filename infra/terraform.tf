terraform {

  required_version = ">=0.12"

  backend "azurerm" {
    resource_group_name  = "terraformstate-rg"
    storage_account_name = "terraformstatestorage987"
    container_name       = "team1-tfstate"
    key                  = "terraform.tfstate"
  }
  required_providers {
    azurerm = {
      source = "hashicorp/azurerm"
      version = "~>2.0"
    }
  }
}
