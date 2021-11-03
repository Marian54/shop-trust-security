resource "azurerm_public_ip" "vmtf_pip" {
  name                = "${var.prefix}-ip"
  location            = var.resource_group_location
  resource_group_name =  azurerm_resource_group.rg-azure-tf.name
  allocation_method   = "Dynamic"
  domain_name_label   = var.hostname
}